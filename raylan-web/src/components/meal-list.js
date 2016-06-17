/* eslint react/jsx-no-bind: 0, react/no-multi-comp: 0, react/jsx-closing-bracket-location: 0 */
import React, { PropTypes } from 'react';
import { fetchMeals, setTitle } from '../actions';
import { connect } from 'react-redux';

/*const computeMealStyle = function(region, selected) {
    let style = {
        padding: 16
    };
    if (region === selected) {
        style['fontWeight'] = 'bold';
        style['backgroundColor'] = 'lightGrey';
    }
    return style;
}*/

export const MealList = React.createClass({
    propTypes: {
        onMealChange: PropTypes.func,
        /*params: PropTypes.shape({
            regionId: PropTypes.string.isRequired
        }),*/
        meals: PropTypes.arrayOf(PropTypes.object)
    },

    handleMealClick(meal) {
        this.props.onMealChange(meal);
    },

    render () {
        if (this.props.meals.length === 0) {
            return <div>No meal</div>
        }
        return (
            <div>
                {
                    this.props.meals.map(meal =>
                        <div key={meal.date}>
                            {meal.amount}
                        </div>
                    )
                }
            </div>
        )
    }
})

const mapStateToProps = (state) => {
    return {
        meals: state.meals,
        httpState: state.http.state
    };
}

export const MealListPage = connect(mapStateToProps)(React.createClass({
    propTypes: {
        dispatch: PropTypes.func.isRequired,
        history: PropTypes.shape({
            push: PropTypes.func.isRequired
        }),
        httpState: PropTypes.string,
/*        params: PropTypes.shape({
            regionId: PropTypes.string.isRequired
        }),*/
        meals: PropTypes.object.isRequired
    },

    contextTypes: {
        router: React.PropTypes.object
    },

    componentDidMount() {
        this.props.dispatch(fetchMeals());
        //this.props.dispatch(setTitle(`Wines from ${this.props.params.regionId}`));
    },

/*
    handleNavigateToMeal(wine) {
        this.context.router.push({
            pathname: `/regions/${this.props.params.regionId}/wines/${wine.id}`
        });
    },
*/

    render () {
        const meals = this.props.meals || { data: [] };
        return (
            <MealList meals={meals.data} />
        );
    }
}));
