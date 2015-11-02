(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#target-list-area'),

        listCollection: null,

        initialize: function (options) {
            options.listCollection.fetch({async: false});
            var first = options.listCollection.first();
            console.log(options.listCollection);
            console.log(first.get('id') + " " + first.get('name'));

            //this.collection.fetch();
            //this.render();
            //this.listenTo(collection, 'change', this.render);
        },

        render: function () {
            this.collection.each(function (item){
                item.render();
                this.$('#target-list').append(item.el);
            }, this);
        }
    });
})();