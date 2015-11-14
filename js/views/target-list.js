(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    var TLItem = require('./target-list-item');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#target-list-area'),

        initialize: function () {
            this.listenTo(this.collection, 'change:selectedListId', this.render);
            this.listenTo(this.collection, 'add remove', this.render);
            //_.bindAll(this, 'fetchCallBack');
            //this.collection.fetch({success: this.fetchCallBack});
        },

        fetchCallBack: function(){
            //var first = this.collection.first();
            //console.log(this.collection);
            //console.log(first.get('id') + " " + first.get('name'));
        },

        render: function () {
            this.$('#target-list-body').empty();
            this.collection.each(function (item) {
                var tlItem = new TLItem({model: item});
                tlItem.render();
                this.$('#target-list-body').append(tlItem.el);
            }, this);
        }
    });
})();