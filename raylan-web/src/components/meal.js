import React, { PropTypes } from 'react';
import { Comments } from './comments';

import { connect } from 'react-redux';
import { fetchMeal, setTitle } from '../actions';

const Styles = {
    Card: {
        padding: 8,
        boxSizing: 'border-box',
        boxShadow: '0 1px 6px rgba(0,0,0,0.12), 0 1px 4px rgba(0,0,0,0.12)',
        minHeight: 280
    },
    Title: {
        fontWeight: 'bold',
        fontSize: '1.2em'
    },
    Info: {
        marginTop: 16,
        marginBottom: 16
    },
    Label: {
        color: 'white',
        marginRight: 8,
        padding: 4,
        background: 'grey',
        borderRadius: '4px'
    },
    Like: {
        cursor: 'pointer',
        color: 'white',
        marginRight: 8,
        padding: 4,
        background: 'lightblue',
        borderRadius: '4px'
    },
    Liked: {
        cursor: 'pointer',
        color: 'black',
        marginRight: 8,
        padding: 4,
        background: 'yellow',
        borderRadius: '4px'
    },
    Image: {
        float: 'left'
    }
};

export const Meal = React.createClass({
    propTypes: {
        meal: PropTypes.shape({
            amount: PropTypes.string,
            date: PropTypes.date
        })
    },

    render() {
        const { meal } = this.props;
        if (!meal) {
            return <div>No information</div>
        }
        return (
            <div style={Styles.Card}>
                <div style={Styles.Title}>{meal.amount}</div>
                <div style={Styles.Info}>
                    <span style={Styles.Label}>Type</span>{meal.date}
                </div>
            </div>
        )
    }
});

const mapStateToProps = (state) => {
    return {
        meal: state.currentWine.meal,
        liked: state.currentWine.liked,
        httpState: state.http.state
    };
}

export const MealPage = connect(mapStateToProps)(React.createClass({
    propTypes: {
        dispatch: PropTypes.func.isRequired,
        history: PropTypes.shape({
            push: PropTypes.func.isRequired
        }),
        httpState: PropTypes.string,
/*        liked: PropTypes.bool,
        params: PropTypes.shape({
            regionId: PropTypes.string.isRequired,
            wineId: PropTypes.string.isRequired
        }),*/
        meal: PropTypes.object
    },

    contextTypes: {
        router: React.PropTypes.object
    },

    componentDidMount() {
        this.props.dispatch(fetchMeal(this.props.params.mealDate)).then(() => {
            //if (this.props.meal) this.props.dispatch(setTitle(this.props.meal.name));
        });
    },

    render() {
        return (
            <div>
                <Meal meal={this.props.meal} />
            </div>
        );
    }
}));
