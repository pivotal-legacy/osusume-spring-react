import React from 'react'
import RestaurantRepository from './RestaurantRepository';

export default class RestaurantList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {'restaurants': []}
    }

    componentDidMount() {
        RestaurantRepository.fetchAll().then(data => {
            this.setState({'restaurants': data});
        });
    }

    render() {
        let restaurants = this.state.restaurants.map(function(restaurant) {
            return (<span className={`restaurant-${restaurant.id}`} key={restaurant.id}>{restaurant.name}</span>)
        });
        return (
            <div>{restaurants}</div>
        );
    }
}