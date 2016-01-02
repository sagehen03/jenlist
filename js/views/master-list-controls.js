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
            if( $('#filter-master-list-area').is(":visible") ) {
                $('#filter-master-list-area').slideUp();
            }
            $('#add-item-area').slideToggle();
        },

        showFilterMasterList: function() {
            if( $('#add-item-area').is(":visible") ){
                $('#add-item-area').slideUp();
            }
            $('#filter-master-list-area').slideToggle();
            $('#filter-text').focus();
        }
    });
})();