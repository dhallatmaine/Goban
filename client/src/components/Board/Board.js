import React from 'react';

import classes from './Board.css';
import goban19 from './goban19.png';

const board = (props) => (
  <div className={classes.Board} style={{backgroundImage: `url(${goban19})`, backgroundSize: '666px 666px'}}>
    <div className={classes.Grid}>
      {props.board}
    </div>
  </div>
)

export default board;
