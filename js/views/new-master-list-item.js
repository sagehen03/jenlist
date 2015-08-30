var Backbone = require('backbone');
var _ = require('underscore');
var $ = require('jquery');
var newItemTemplate = require('./templates/add-item.jade');

var NewMasterListItemView = Backbone.View.extend({

    events: {
        'submit form': 'create'
    },

    render: function () {
        this.$el.html(newItemTemplate());
        return this;
    },

    create: function (e) {
        e.preventDefault();
        var $input = this.$('input'),
            val = $input.val().trim();

        if (val) {
            // TODO: Handle when this fails to add.
            this.collection.create({name: val});

            // Reset the input.
            $input.val('');
        }
    }
});

module.exports = NewMasterListItemView;
