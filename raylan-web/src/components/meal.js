import React from 'react';

const MealStyle = {
    padding: 8,
    boxShadow: '0 1px 6px rgba(0,0,0,0.12), 0 1px 4px rgba(0,0,0,0.12)'
};

const Meal = React.createClass({

    propTypes: {
        meal: React.PropTypes.shape({
            label: React.PropTypes.string.isRequired,
            price: React.PropTypes.number.isRequired,
            date: React.PropTypes.string.isRequired
        })
    },

    render() {
        let meal = this.props.meal;
        if (!meal) {
            return <div>No information</div>
        }

        return (
            /*     TODO SPE tests js react
             <div style={MealStyle}>
             {this.props.date} : {this.props.amount}€ - {this.props.name}
             </div>*/

            <div>
                <div className="1/4 grid__cell">
                    {meal.date}
                </div>
                <div className="1/3 grid__cell">
                    {meal.label}
                </div>
                <div className="5/12 grid__cell">
                    {meal.price}
                </div>
            </div>

        )
            ;
    }
});

export default Meal;