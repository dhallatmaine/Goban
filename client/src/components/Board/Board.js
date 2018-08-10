import React, { Component } from 'react';
import axios from 'axios';

import classes from './Board.css';
import goban19 from './goban19.png';

class Board extends Component {
  state = {
    board: [],
    turn: null
  };

  componentDidMount() {
    axios.get('http://localhost:8080/api/go')
      .then(response => {
        let divs = [];
        for (let i = 0; i < response.data.board.length; i++) {
          let inner = [];
          for (let j = 0; j < response.data.board[i].length; j++) {
            if (response.data.board[i][j] === "WHITE") {
              inner.push(<div className={classes.WhiteStone} key={j + '' + i}></div>);
            } else if (response.data.board[i][j] === "BLACK") {
              inner.push(<div className={classes.BlackStone} key={j + '' + i}></div>);
            } else {
              if (response.data.turn === "BLACK") {
                inner.push(<div className={classes.Black} key={j + '' + i}></div>);
              } else {
                inner.push(<div className={classes.White} key={j + '' + i}></div>);
              }
            }
          }
          divs.push(inner);
        }
        this.setState({board: divs, turn: response.data.turn});
      });
  }

  render() {
    return (
      <div className={classes.Board} style={{backgroundImage: `url(${goban19})`, backgroundSize: '666px 666px'}}>
        <div className={classes.Grid}>
          {this.state.board}
        </div>
      </div>
    );
  }
};

export default Board;
