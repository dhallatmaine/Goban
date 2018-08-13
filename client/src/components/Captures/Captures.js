import React from 'react';

import classes from './Captures.css';

const captures = (props) => (
  <div className={classes.Captures}>
    {props.color} has {props.captures} captures
  </div>
);

export default captures;
