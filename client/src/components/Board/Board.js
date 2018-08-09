import React from 'react';

import classes from './Board.css';
import goban19 from './goban19.png';

const board = (props) => {
  let divs = [];
  for (let i = 0; i < 19; i++) {
    let inner = [];
    for (let j = 0; j < 19; j++) {
      if (i*j%2===0) {
        inner.push(<div className={classes.Black}></div>);
      } else {
        inner.push(<div className={classes.White}></div>);
      }
    }
    divs.push(inner);
  }

  return (
    <div className={classes.Board} style={{backgroundImage: `url(${goban19})`, backgroundSize: '666px 666px'}}>
      <div className={classes.Grid}>
        {divs}
      </div>
    </div>
  );
};

export default board;
