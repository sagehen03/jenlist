(function(){
    'use strict';
    var Backbone = require("backbone");
    var Category = require('../models/category')
    module.exports = Backbone.Collection.extend({
        model: Category,
        url: 'http://localhost:8092/jenlist/categories'
    });
})();