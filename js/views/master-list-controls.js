(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');

    module.exports = Backbone.View.extend({

        el: $('#master-list-controls'),

        events: {
            'click #add-new-item': 'showAddNewMasterListItem',
            'click #filter-items': 'showFilterMasterList'
        },

        showAddNewMasterListItem: function(){
            if( $('#add-item-area').is(":visible") ) {
                $('#add-item-area').slideUp();
                this.attributes.router.navigate('/');
            } else {
                this.attributes.router.navigate("addItemMl", {trigger: true});
            }
        },

        showFilterMasterList: function() {
            if( $('#filter-master-list-area').is(":visible") ){
                $('#filter-master-list-area').slideUp();
                this.attributes.router.navigate('/');
            } else {
                this.attributes.router.navigate("filterMl", {trigger: true});
            }
        }
    });
})();