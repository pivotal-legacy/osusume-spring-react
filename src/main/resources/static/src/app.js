import React from 'react'
import { render } from 'react-dom'
import { Router, Route, browserHistory } from 'react-router'
import RestaurantList from './RestaurantList'

render((
    <Router history={browserHistory}>
        <Route path="/" component={RestaurantList} />
    </Router>
), document.getElementById('react'));
