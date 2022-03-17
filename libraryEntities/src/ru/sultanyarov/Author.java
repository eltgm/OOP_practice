package ru.sultanyarov;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Author extends User {
    private List<Resource> createdResources;

    public List<Resource> getCreatedResources() {
        return this.createdResources;
    }

    public boolean createNewResource(Resource resource) {
        return this.createdResources.add(resource);
    }

    public Map<String, List<Review>> getCreatedResourceReviews() {
        Map<String, List<Review>> createdResourcesReviewsMap = new HashMap<>(createdResources.size());

        for (Resource createdResource : createdResources) {
            createdResourcesReviewsMap.put(createdResource.getName(), createdResource.getResourceReviews());
        }

        return createdResourcesReviewsMap;
    }
}
