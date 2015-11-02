(function(){
    'use strict';
    var Backbone = require("backbone");
    var env = require('../env');
    var ListItem = require('../models/target-list-item')
    module.exports = Backbone.Collection.extend({
        model: ListItem,

        selectedList: null,

        initialize: function(options){
            this.selectedList = options.selectedList;
            this.updateUrl();
            this.listenTo(this.selectedList, 'change:id', this.updateUrl)
        },

        updateUrl: function(){
            this.url = env.API_BASE + '/shopping-list/' + this.selectedList.get('id');
        }

    });
})();