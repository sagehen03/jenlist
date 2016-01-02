(function(){
    'use strict';
    var Backbone = require("backbone");
    var $ = require('jquery');
    var _ = require('underscore');

    module.exports = Backbone.View.extend({

        el: $('#filter-master-list-area'),

        events: {
            'keydown #filter-text': 'filter'
        },

        searching : 0,

        initialize: function(){
            _.bindAll(this, 'findMatches');
        },

        filter: function( event ){

            switch ( event.which ){
                case 27:
                    break;
                default:
                    clearTimeout(this.searching);
                    this.searching = setTimeout(this.findMatches, 300);
                    break;

            }
        },

        findMatches: function(){
            var startsWith = $('#filter-text').val();
            Backbone.trigger('filterEvent', {'startsWith': startsWith.toLowerCase()});
        }
    });
})();