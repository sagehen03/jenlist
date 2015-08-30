var Backbone = require('backbone');
var _ = require('underscore');
var $ = require('jquery');
var newItemTemplate = require('../views/templates/add-item.jade');

var NewMasterListItemView = Backbone.View.extend({
    el:  '#add-item',

    events: {
        'keypress input': 'createOnEnter'
    },

    initialize: function(options){
        this.masterCollection = options.masterCollection;
    },

    render: function () {
        this.$el.html(newItemTemplate());
        return this;
    },

    createOnEnter: function (e) {
        if (e.which === 13 && this.$('input').val().trim()) {
            console.log("Hello!");
            this.masterCollection.create({name: this.$input.val().trim()});
            this.$input.val('');
        }
    }
});

module.exports = NewMasterListItemView;
