package com.rezoleo.zer0data.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

import java.util.Date;

import fr.applicationcore.object.APIObject;

/**
 * Created by Thomas on 8/01/16.
 */
public class Contributor extends APIObject {
    protected boolean registered;
    @Expose
    @Since(1.0D)
    protected String _id = null;
    @Expose
    @Since(1.0D)
    protected String login = null;
    @Expose
    @Since(1.0D)
    protected String creator = null;
    @Expose
    @Since(1.0D)
    protected Date created = null;
    @Expose
    @Since(1.0D)
    protected String creatorService = null;

    public Contributor() {
    }

    public Contributor(String _id, String login, String creator, Date created, String creatorService) {
        this._id = _id;
        this.login = login;
        this.creator = creator;
        this.created = created;
        this.creatorService = creatorService;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatorService() {
        return this.creatorService;
    }

    public void setCreatorService(String creatorService) {
        this.creatorService = creatorService;
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this._id == null?0:this._id.hashCode());
        result1 = 31 * result1 + (this.created == null?0:this.created.hashCode());
        result1 = 31 * result1 + (this.creator == null?0:this.creator.hashCode());
        result1 = 31 * result1 + (this.creatorService == null?0:this.creatorService.hashCode());
        result1 = 31 * result1 + (this.login == null?0:this.login.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            Contributor other = (Contributor)obj;
            if(this._id == null) {
                if(other._id != null) {
                    return false;
                }
            } else if(!this._id.equals(other._id)) {
                return false;
            }

            if(this.created == null) {
                if(other.created != null) {
                    return false;
                }
            } else if(!this.created.equals(other.created)) {
                return false;
            }

            if(this.creator == null) {
                if(other.creator != null) {
                    return false;
                }
            } else if(!this.creator.equals(other.creator)) {
                return false;
            }

            if(this.creatorService == null) {
                if(other.creatorService != null) {
                    return false;
                }
            } else if(!this.creatorService.equals(other.creatorService)) {
                return false;
            }

            if(this.login == null) {
                if(other.login != null) {
                    return false;
                }
            } else if(!this.login.equals(other.login)) {
                return false;
            }

            return true;
        }
    }

    public boolean isEmpty() {
            return !registered;
        }
}
