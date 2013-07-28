define(function(require) {

    var LibraryView = require('modules/library/libraryView'),
        LibraryRepository = require('modules/library/libraryRepository'),
        $ = require('jquery'),
        sinon = require('sinon'),
        responseFaker = require('responseFaker');

    describe('LibraryView', function() {
        it('has books', function() {
            var el = $('<div></div>');

            var libraryView = LibraryView({
                el: el,
                libraryId: 1,
                libraryRepository: LibraryRepository()
            });

            var response = {"books":[{"title":"Of Mice and Men","uri":"/book/1"},{"title":"Sult","uri":"/book/2"}]};
            responseFaker.fakeResponse(response, {}, function() {
                libraryView.render();
            });

            expect(el.find(".books li").size()).toBe(2);
        });
    });
});
