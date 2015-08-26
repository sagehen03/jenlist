'use strict';
var Backbone = require("backbone");
var _ = require('underscore');
var ListItem = require('models/list-item');
var List = Backbone.Collection.extend({
    model: ListItem,
    url: 'http://localhost:8092/jenlist/items',

    fetch: function(options) {
        //Call Backbone's fetch
         var call = Backbone.Collection.prototype.fetch.call(this, options);
        console.log(call);
        return call;
    },

    initialize: function(){
        this.on('request', this.beginSync);
        this.on('sync', this.finishSync);
    },

    finishSync: function(){
        console.log("After sync");
    },

    beginSync: function(){
        console.log("Before sync");
    }
});

module.exports = List;