var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: './spec/RestaurantListSpec.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname,
        filename: './spec/spec.js'
    },
    module: {
        loaders: [
            {
                test: /\.js?$/,
                exclude: /node_modules/,
                loader: 'babel'
            }
        ]
    }
};