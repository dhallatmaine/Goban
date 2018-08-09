import React from 'react';

import Board from '../Board/Board';
import classes from './Layout.css';

const layout = () => {
  return (
    <div className={classes.Layout}>
      <Board />
      <div>WhiteCaptures</div>
      <div>BlackCaptures</div>
    </div>
  );
};

export default layout;
