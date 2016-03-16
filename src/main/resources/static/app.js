import React from 'react'
import { render } from 'react-dom'
import { Router, Route, browserHistory } from 'react-router'

class App extends React.Component {
    render() {
        return (
            <div></div>
        );
    }
}

render((
    <Router history={browserHistory}>
        <Route path="/" component={App} />
    </Router>
), document.getElementById('react'));
