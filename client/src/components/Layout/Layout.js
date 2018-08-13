import React, { Component } from 'react';
import axios from 'axios';

import Board from '../Board/Board';
import Captures from '../Captures/Captures';
import classes from './Layout.css';
import boardClasses from '../Board/Board.css';

class Layout extends Component {

  state = {
    board: [],
    turn: null,
    captures: {
      BLACK: 0,
      WHITE: 0
    }
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
        this.setState({
          board: divs,
          turn: response.data.turn,
          captures: response.data.captures
        });
      });
  }

  updateBoard = (board) => {
    let divs = [];
    for (let i = 0; i < board.length; i++) {
      let inner = [];
      for (let j = 0; j < board[i].length; j++) {
        let className = null;
        if (board[j][i] === "WHITE") {
          className = boardClasses.WhiteStone;
        } else if (board[j][i] === "BLACK") {
          className = boardClasses.BlackStone;
        } else {
          if (this.state.turn === "BLACK") {
            className = boardClasses.White;
          } else {
            className = boardClasses.Black;
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
        this.setState({
          board: divs,
          turn: response.data.turn,
          captures: response.data.captures
        });
      });
  }

  render() {
    return (
      <div className={classes.Layout}>
        <Board board={this.state.board} turn={this.state.turn} />
        <Captures color="WHITE" captures={this.state.captures.WHITE} />
        <Captures color="BLACK" captures={this.state.captures.BLACK} />
      </div>
    )
  }
};

export default Layout;
