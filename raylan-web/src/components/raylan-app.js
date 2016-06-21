import React from 'react';
import Meals from './meal-list';

const RaylanApp = React.createClass({

    getInitialState() {
        return {
            meals: [{label: 'bouchon', amount: 10, date: '23/23'}],
            selectedMeal: null
        };
    },

    componentDidMount() {
        fetch('/api/meals/all')
            .then(r => r.json())
            .then(data => {
                this.setState({
                    meals: data,
                    selectedMeal: data[0]
                });
                // TODO Charger les vins de la région : this.loadWinesByRegion(data[0]);
            })
            .catch(response => {
                console.error(response);
            });
    },

    render() {
        return (
           <Meals meals={this.state.meals}/>
        )
    }
})

export default RaylanApp;
