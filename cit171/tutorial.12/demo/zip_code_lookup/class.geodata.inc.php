<?php
/**
 * EyeGeoData
 * Retrieve geographical information of a postal/zip/post code
 *
 * LICENSE: This source file is subject to the BSD license
 * that is available through the world-wide-web at the following URI:
 * http://www.eyesis.ca/license.txt.  If you did not receive a copy of
 * the BSD License and are unable to obtain it through the web, please
 * send a note to mike@eyesis.ca so I can send you a copy immediately.
 *
 * @author     Micheal Frank <mike@eyesis.ca>
 * @copyright  2008 Eyesis
 * @license    http://www.eyesis.ca/license.txt  BSD License
 * @version    v1.0.0 6/18/2008 3:13:34 PM
 * @link       http://www.eyesis.ca/projects/geodata.html
 */

class EyeGeoData
{
	const FEED = 'http://api.eyesis.ca/geo.xml';

	const KMS = 1;
	const MIS = 2;

	private $key = false;
	private $status_code, $lookups_left;
	public $result = false;
	public $out = 'xml';

	/**
	* Set a key for premium accounts
	* 
	* @param string $key Key provided by Eyesis for premium accounts
	*/
	public function setKey($key)
	{

		$this->key = $key;

	}

	/**
	* Get postal/zip code information
	* 
	* @param string $code The postal/zip code you want to lookup
	* @return mixed The result of the query, false on error
	*/
	public function query($code)
	{

		// Build the query
		$query = '?code=' . urlencode($code);
		if ($this->key)
			$query .= '&key=' . urlencode($this->key);

		$info = false;

		if ($this->out == 'xml')
		{
			// Use XML feed and SimpleXML

			if ($feed = new SimpleXMLElement(self::FEED . $query, NULL, true))
			{

				$this->status_code		= (integer) $feed->Request->StatusCode;
				$this->lookups_left		= (integer) $feed->Client->LookupsLeft;

				if ($this->status_code == 200)
				{
					$info = array (
						'PostalCode' 	=> (string) $feed->Details->PostalCode,
						'City' 				=> (string) $feed->Details->City,
						'Province' 		=> (string) $feed->Details->Province,
						'Country' 		=> (string) $feed->Details->Country,
						'AreaCode' 		=> (integer) $feed->Details->AreaCode,
						'TimeZone' 		=> (integer) $feed->Details->TimeZone,
						'Coordinates' => array (
							'Latitude' 		=> (float) $feed->Details->Coordinates->Latitude,
							'Longitude' 	=> (float) $feed->Details->Coordinates->Longitude
						)
					);
				}

			}

		} else {
			// Use Serialized feed

			if ($feed = file_get_contents(self::FEED . $query . '&out=php'))
			{

				$feed = unserialize($feed);

				$this->status_code		= (integer) $feed['PostalCode']['Request']['StatusCode'];
				$this->lookups_left		= (integer) $feed['PostalCode']['Client']['LookupsLeft'];

				if ($this->status_code == 200)
					$info = $feed['PostalCode']['Details'];

			}

		}

		$this->result = $info;

    return $this->result;

	}

	/**
	* Get the status code of the previous result
	* 
	* @return mixed
	*/
	public function getStatusCode()
	{

		return ($this->status_code) ? $this->status_code : false;

	}

	/**
	* Get the amount of lookups left
	* 
	* @return mixed
	*/
	public function getLookupsLeft()
	{

		return ($this->lookups_left) ? $this->lookups_left : false;

	}

	/**
	* Calculates the distance between this result and another GeoData object's result
	* 
	* @param GeoData $dest The object to compare to
	* @param integer $units The distance units
	* @return float
	*/
	public function calcDistance(EyeGeoData $dest, $units = self::KMS, $round = 3)
	{

		if (!$dest->result or !$this->result)
			trigger_error('Result empty; query either failed or has not been run', E_USER_ERROR);

		$dist = rad2deg(acos(sin(deg2rad($this->result['Latitude'])) * sin(deg2rad($dest->result['Coordinates']['Latitude'])) +  
			cos(deg2rad($this->result['Coordinates']['Latitude'])) * cos(deg2rad($dest->result['Coordinates']['Latitude'])) * 
			cos(deg2rad($this->result['Coordinates']['Longitude'] - $dest->result['Coordinates']['Longitude'])))) * 60 * 1.1515;

		// Convert to kms
		if ($units == self::KMS)
			$dist *= 1.609344;

		$dist = round($dist, $round); // Round off

    return (float) $dist;

	}

	/**
	* Convert this object to a string
	* 
	* @return string
	*/
	public function __toString()
	{

		if ($this->result)
			return print_r($this->result, true);
		else
			return "I've got nothing to say";

	}
}