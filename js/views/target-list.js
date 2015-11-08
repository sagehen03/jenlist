(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    var _ = require('underscore');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#target-list-area'),

        initialize: function () {
            this.listenTo(this.collection, 'change:selectedListId', this.render);
            //_.bindAll(this, 'fetchCallBack');
            //this.collection.fetch({success: this.fetchCallBack});
        },

        fetchCallBack: function(){
            //var first = this.collection.first();
            //console.log(this.collection);
            //console.log(first.get('id') + " " + first.get('name'));
        },

        render: function () {
            this.collection.each(function (item){
                item.render();
                this.$('#target-list').append(item.el);
            }, this);
        }
    });
})();