import React from 'react';

class DogSelect extends React.Component {
  render() {
    return (
      <select id="breed" onChange={this.props.getBreed}>
      <option value="dachshund">Dachshund</option>
      <option value="maltese">Maltese</option>
      <option value="whippet">Whippet</option>
    </select>
    );
  }
}

export default DogSelect;