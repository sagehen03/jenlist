(function(){
    'use strict';
    var Backbone = require("backbone");
    var Category = require('../models/category');
    module.exports = Backbone.Collection.extend({
        model: Category,
        url: '/categories',

        comparator: function(category){
            return category.get('name');
        }
    });
})();