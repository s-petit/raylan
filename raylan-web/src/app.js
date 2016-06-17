/* eslint react/jsx-max-props-per-line: 0 */

import 'whatwg-fetch';

import React, { PropTypes } from 'react';

import { RaylanApp } from './components/raylan-app';
import { MealPage } from './components/meal';
import { NotFound } from './components/not-found';

import { Router, Route, browserHistory, IndexRoute } from 'react-router';

import { Provider } from 'react-redux';
import { createStore, applyMiddleware, compose } from 'redux';
import { syncHistoryWithStore } from 'react-router-redux';
import thunk from 'redux-thunk';
import { app } from './reducers';
//import { fetchLikesCount, fetchCommentsCount } from './actions';
import { DevTools } from './components/devtools';

const store = compose(applyMiddleware(thunk), DevTools.instrument())(createStore)(app);

export const App = React.createClass({
    propTypes: {
        history: PropTypes.object, // eslint-disable-line
    },
    componentDidMount() {
/*        <Route path="regions/:regionId" component={MealListPage} />
        <Route path="regions/:regionId/meals/:wineId" component={MealPage} />*/
        /*        store.dispatch(fetchLikesCount());
        store.dispatch(fetchCommentsCount());*/
    },
    render() {
        const history = syncHistoryWithStore(this.props.history || browserHistory, store);
        return (
            <Provider store={store}>
                <Router history={history}>
                    <Route path="/" component={RaylanApp}>
                        <IndexRoute component={MealPage} />
                        <Route path="*" component={NotFound} />
                    </Route>
                </Router>
            </Provider>
        );
    }
});
