import React from 'react';

class DogImage extends React.Component {
  render() {
    return(
      <img src={this.props.img} alt={this.props.dogBreed}/>
    );
  }
}

export default DogImage;