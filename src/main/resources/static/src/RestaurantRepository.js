var RestaurantRepository = {
    fetchAll: function () {
        return fetch("http://localhost:8080/api/restaurants").then(r => r.json());
    }
};
export default RestaurantRepository;
