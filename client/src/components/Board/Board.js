import React, { Component } from 'react';
import axios from 'axios';

import classes from './Board.css';
import goban19 from './goban19.png';

class Board extends Component {
  state = {
    board: [],
    turn: null
  };

  makeMoveHandler = (x, y, color) => {
    console.log("x:" + x + " y:" + y + " color:" + color);
    const position = {
      x: x,
      y: y,
      color: color
    };
    axios.post('http://localhost:8080/api/go', position)
      .then(response => {
        let divs = this.updateBoard(response.data.board);
        this.setState({board: divs, turn: response.data.turn});
      });
  }

  updateBoard = (board) => {
    let divs = [];
    for (let i = 0; i < board.length; i++) {
      let inner = [];
      for (let j = 0; j < board[i].length; j++) {
        let className = null;
        if (board[j][i] === "WHITE") {
          className = classes.WhiteStone;
        } else if (board[j][i] === "BLACK") {
          className = classes.BlackStone;
        } else {
          if (this.state.turn === "BLACK") {
            className = classes.White;
          } else {
            className = classes.Black;
          }
        }
        inner.push(
          <div
            className={className}
            key={j + '' + i}
            onClick={() => this.makeMoveHandler(j, i, this.state.turn)}></div>
        );
      }
      divs.push(inner);
    }
    return divs;
  }

  componentDidMount() {
    axios.get('http://localhost:8080/api/go')
      .then(response => {
        let divs = this.updateBoard(response.data.board);
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
