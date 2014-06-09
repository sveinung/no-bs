define(function(require) {

    var po = require('po');

    return po.create({
        openMenu: po.button(".dropdown-trigger"),

        chooseOption: function(option) {
            this.$(".dropdown-menu a[data-value='" + option + "']").click();
            return this;
        },

        expectToHaveChosen: function(option) {
            expect(this.$(".dropdown-trigger .chosen-value")).toHaveText(option);
            return this;
        },

        expectToBeHidden: function() {
            expect(this.$(".dropdown-menu")).toHaveClass("hide");
            return this;
        },

        expectToBeVisible: function() {
            expect(this.$(".dropdown-menu")).not.toHaveClass("hide");
            return this;
        }
    });
});
