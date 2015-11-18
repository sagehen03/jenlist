(function(){
    'use strict';
    var Backbone = require("backbone");
    var Category = require('../models/category');
    var env = require('../env')
    module.exports = Backbone.Collection.extend({
        model: Category,
        url: env.API_BASE + '/categories'
    });
})();