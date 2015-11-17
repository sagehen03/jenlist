(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    var TLItem = require('./target-list-item');
    require('jquery-ui');

    module.exports = Backbone.View.extend({

        el: $('#target-list-area'),

        events: {
            'click th.sort': 'sortList'
        },

        initialize: function () {
            this.listenTo(this.collection, 'change:selectedListId', this.render);
            this.listenTo(this.collection, 'add remove sort', this.render);
        },

        sortList: function(e){
            var sortBy = $(e.target).text().toLowerCase();
            this.collection.sortItems(sortBy);
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