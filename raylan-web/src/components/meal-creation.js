import React from 'react';
import Meal from './meal'

const MealCreation = React.createClass({
    render () {
        return (
            <div className="grid">

                { this.props.meals.map(meal => <div key={meal.date}><Meal meal={meal}/></div>) }
            </div>
        )
    }
})

export default MealCreation;