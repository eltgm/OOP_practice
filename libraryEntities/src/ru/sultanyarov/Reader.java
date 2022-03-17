package ru.sultanyarov;

import java.util.Iterator;
import java.util.List;

public class Reader extends User {
    private boolean isBlocked;
    private Sex sex;
    private List<Resource> resourcesInUse;

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Resource> getResourcesInUse() {
        return resourcesInUse;
    }

    public void setResourcesInUse(List<Resource> resourcesInUse) {
        this.resourcesInUse = resourcesInUse;
    }

    public boolean takeResource(Resource resource) {
        return this.resourcesInUse.add(resource);
    }

    public Resource returnResource(String resourceName) {
        Iterator<Resource> resourceIterator = resourcesInUse.iterator();
        while (resourceIterator.hasNext()) {
            Resource resource = resourceIterator.next();
            if (resource.getName().equals(resourceName)) {
                resourceIterator.remove();
                return resource;
            }
        }

        return null;
    }

    public boolean leaveFeedback(String resourceName, String comment, int rate) {
        for (Resource resource : this.resourcesInUse) {
            if (resource.getName().equals(resourceName)) {
                return resource.getResourceReviews().add(new Review(this, resource, comment, rate));
            }
        }

        return false;
    }

    public void deleteAccount() {
        this.isBlocked = true;
    }
}
