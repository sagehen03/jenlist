(function () {
    'use strict';
    var Backbone = require("backbone");
    module.exports = Backbone.Collection.extend({
        sortDirection: 1,
        sortAttribute: 'category',

        comparator: function (a, b) {
            var a = a.get(this.sortAttribute),
                b = b.get(this.sortAttribute);

            if (a == b) return 0;

            if (this.sortDirection == 1) {
                return a > b ? 1 : -1;
            } else {
                return a < b ? 1 : -1;
            }
        },

        sortItems: function(attr){
            if(this.sortAttribute != attr){
                this.sortDirection = 1;
            } else {
                this.sortDirection *= -1;
            }
            this.sortAttribute = attr;
            this.sort();
        }
    });
})();