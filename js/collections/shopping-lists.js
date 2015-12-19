var Backbone = require("backbone");
var List = require('../models/list');

module.exports = Backbone.Collection.extend({

    model: List,
    url: '/shopping-list',

    initialize: function(){
        this.listenTo(Backbone, "newShoppingList", this.addShoppingList);
    },

    addShoppingList: function(data){
        this.create(data, {wait: true});
    }

});
