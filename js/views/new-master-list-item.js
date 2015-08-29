(function(){
    'use strict'
    var Backbone = require('backbone');
    var _ = require('underscore');
    var $ = require('jquery');
    var NewMasterListItemView = Backbone.View.extend({
        el:  '#newItemArea',

        events: {
            'keypress #newItem': 'createOnEnter'
        },

        initialize: function(options){
            this.masterCollection = options.masterCollection;
            this.render();
            this.$input = $('#newItem');
            console.log(this.$input);
        },

        render: function () {
            var tmpl = _.template($('#new-item-template').html());
            this.$el.html(tmpl('{}'));
            return this;
        },

        createOnEnter: function (e) {
            if (e.which === 13 && this.$input.val().trim()) {
                console.log("Hello!");
                this.masterCollection.create({name: this.$input.val().trim()});
                this.$input.val('');
            }
        }
    });
    module.exports = NewMasterListItemView;

})();