import RestaurantList from '../src/RestaurantList';
import React from 'react';
import ReactDOM from 'react-dom';
import TestUtils from 'react-addons-test-utils';
import RestaurantRepository from '../src/RestaurantRepository';

describe('RestaurantList component', () => {
    let renderedRestaurantList;

    afterEach(() => {
        ReactDOM.unmountComponentAtNode(ReactDOM.findDOMNode(renderedRestaurantList).parentNode);
    });

    it('fetches the data from the repository and sets the data on the component state', (done) => {
        let data = [{'id': 1, 'name': 'Afuri'}];
        let promiseResolver = {"then": (thenFunction) => {
            thenFunction(data);
        }};
        spyOn(RestaurantRepository, 'fetchAll').and.returnValue(promiseResolver);

        renderedRestaurantList = TestUtils.renderIntoDocument(<RestaurantList />);

        expect(RestaurantRepository.fetchAll).toHaveBeenCalled();
        setTimeout(function() {
            expect(renderedRestaurantList.state.restaurants).toEqual(data);

            var div = TestUtils.findRenderedDOMComponentWithClass(renderedRestaurantList, 'restaurant-1');
            expect(div.textContent).toEqual('Afuri');

            done()
        },0)
    });

});