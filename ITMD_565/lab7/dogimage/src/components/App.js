import React from 'react';
import img from '../images/logo.svg';
import DogImage from "./DogImage";
import DogSelect from './DogSelect';

class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      dogBreed: "dachshund",
      img: ""
    };
    this.getDogImage = this.getDogImage.bind(this);
    this.getBreed = this.getBreed.bind(this);
  }

  getDogImage(){
    // console.log(this.getDogImage);
    fetch("https://dog.ceo/api/breed/dachshund/images/random")
      .then((res) => {return res.json();
      }).then((json) => {
        this.setState({
          img: json.message
        });
      });
  }

  getNewDogImage(dogBreed){
    // console.log(this.getDogImage);
    fetch(`https://dog.ceo/api/breed/${dogBreed}/images/random`)
      .then((res) => {return res.json();
      }).then((json) => {
        this.setState({
          img: json.message
        });
      });
  }

  getBreed(){
    console.log( document.getElementById("breed").value);
    let dogBreed=document.getElementById("breed").value;
    this.setState({
      dogBreed: dogBreed
    })
    this.getNewDogImage(dogBreed);
  }
  componentDidMount(){
    this.getDogImage();
  }

  render() {
    return (
    	<div>
        <h1>{this.state.dogBreed} Dog Image Generator</h1>
        <h2>Deborah Barndt - dbarndt@hawk.iit.edu - ITMD-565</h2>
        <p>Please press the button to generate a new random image.</p>
        <DogSelect getBreed={this.getBreed}/>
        <button onClick={this.getBreed}>Fetch</button>
        <hr/>
        <DogImage img={this.state.img} alt={this.state.dogBreed}/>
      </div>
    );
  }
}

export default App;