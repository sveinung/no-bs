define(function() {

    var LibraryRepository = function() {
        var urlRoot = "http://localhost:8080/rest/library/";

        var getLibrary = function(libraryId) {
            var libraryPromise = $.ajax(urlRoot + libraryId, {
                accepts: {
                    json: 'application/json'
                }
            });

            return libraryPromise;
        };

        return {
            getLibrary: getLibrary
        }
    }

    return LibraryRepository;
});