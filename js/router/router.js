(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');

    module.exports = Backbone.Router.extend({

        routes: {
            "addItemMl": "addItemMl",
            "filterMl": "filterMl"
        },

        addItemMl: function() {
            if( $('#filter-master-list-area').is(":visible") ) {
                $('#filter-master-list-area').slideUp();
            }
            $('#add-item-area').slideToggle();
        },

        filterMl: function(){
            if( $('#add-item-area').is(":visible") ){
                $('#add-item-area').slideUp();
            }
            $('#filter-master-list-area').slideToggle();
            $('#filter-text').focus();
        }

    });
})();