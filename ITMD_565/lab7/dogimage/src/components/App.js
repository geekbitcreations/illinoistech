import React from 'react';
import img from '../images/logo.svg';
import DogImage from "./DogImage";
import DogSelect from "./DogSelect";

class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      img: " ",
    };
  }

  componentDidMount(){
    // getDogImage method runs in here
  }

  componentDidUpdate(){

  }

  render() {
    return (
    	<div>
        <h1>Breed Dog Image Generator</h1>
        <h2>Deborah Barndt - dbarndt@hawk.iit.edu - ITMD-565</h2>
        <p>Please press the button to generate a new random image.</p>
        <button >Fetch</button>
        <hr/>
      </div>
    );
  }
  
  getDogImage() {
    fetch("https://dog.ceo/api/breed/dachshund/images/random")
      .then((res) => {return res.json();
      }).then((json) => {
        this.setState({
          //img.json.message
        });
      });
  }

  /*getNewDogImage() {
    // code for grabbing new dog image
  }*/
}

export default App;