import React from 'react';
import Meal from './meal'

const Meals = React.createClass({
    render () {
        return (
            <div className="grid">
                <div className="1/4 grid__cell">
                    <h2>Date</h2>
                </div>
                <div className="1/3 grid__cell">
                    <h2>Label</h2>
                </div>
                <div className="5/12 grid__cell">
                    <h2>Price</h2>
                </div>
                { this.props.meals.map(meal => <div key={meal.date}><Meal meal={meal}/></div>) }
            </div>
        )
    }
})

export default Meals