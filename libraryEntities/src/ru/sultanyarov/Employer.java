package ru.sultanyarov;

import java.util.List;

public class Employer extends User {
    private String position;
    private List<Reader> readers;
    private List<Resource> availableResources;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean createUser(Reader user) {
        this.readers.add(user);
        return true;
    }

    public boolean blockUser(String userFio) {
        for (Reader reader : this.readers) {
            if (reader.getFio().equals(userFio)) {
                reader.setBlocked(true);
                return true;
            }
        }

        return false;
    }

    public boolean unblockUser(String userFio) {
        for (Reader reader : this.readers) {
            if (reader.getFio().equals(userFio) && reader.isBlocked()) {
                reader.setBlocked(false);
                return true;
            }
        }

        return false;
    }

    public List<Reader> getReaders() {
        return this.readers;
    }

    public List<Resource> getAvailableResources() {
        return this.availableResources;
    }

    public Resource giveResource(String resourceName) {
        for (Resource availableResource : this.availableResources) {
            if (availableResource.getName().equals(resourceName)) {
                return availableResource;
            }
        }

        return null;
    }

    public boolean returnResource(Resource resource) {
        return this.availableResources.add(resource);
    }
}
