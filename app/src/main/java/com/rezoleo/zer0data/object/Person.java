package com.rezoleo.zer0data.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import fr.applicationcore.object.APIObject;

/**
 * Created by Thomas on 8/01/16.
 */
public class Person implements APIObject {
    @Expose
    @Since(1.0D)
    protected String _id = null;
    @Expose
    @Since(1.0D)
    protected String login = null;
    @Expose
    @Since(1.0D)
    protected String lastname = null;
    @Expose
    @Since(1.0D)
    protected String firstname = null;
    @Expose
    @Since(1.0D)
    protected String sex = null;
    @Expose
    @Since(1.0D)
    protected Date birthdate = null;
    @Expose
    @Since(1.0D)
    protected boolean major;
    @Expose
    @Since(1.0D)
    protected String mail = null;
    @Expose
    @Since(1.0D)
    protected String tel = null;
    @Expose
    @Since(1.0D)
    protected String picture = null;
    @Expose
    @Since(1.0D)
    protected SortedSet<String> tags = new TreeSet();
    @Expose
    @Since(1.0D)
    protected String creator = null;
    @Expose
    @Since(1.0D)
    protected Date created = null;
    @Expose
    @Since(1.0D)
    protected String creatorService = null;
    @Expose
    @Since(1.0D)
    protected String updator = null;
    @Expose
    @Since(1.0D)
    protected Date updated = null;
    @Expose
    @Since(1.0D)
    protected String updatorService = null;
    @Expose
    @Since(1.0D)
    protected boolean registered;

    public Person() {
    }

    public Person(String _id, String login, String lastname, String firstname, String sex, Date birthdate, boolean major, String mail, String tel, String picture, SortedSet<String> tags, String creator, Date created, String creatorService, String updator, Date updated, String updatorService, boolean registered) {
        this._id = _id;
        this.login = login;
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.birthdate = birthdate;
        this.major = major;
        this.mail = mail;
        this.tel = tel;
        this.picture = picture;
        this.tags = tags;
        this.creator = creator;
        this.created = created;
        this.creatorService = creatorService;
        this.updator = updator;
        this.updated = updated;
        this.updatorService = updatorService;
        this.registered = registered;
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

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean getMajor() {
        return this.major;
    }

    public void setMajor(boolean major) {
        this.major = major;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public SortedSet<String> getTags() {
        return this.tags;
    }

    public void setTags(SortedSet<String> tags) {
        this.tags = tags;
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

    public String getUpdator() {
        return this.updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatorService() {
        return this.updatorService;
    }

    public void setUpdatorService(String updatorService) {
        this.updatorService = updatorService;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this._id == null?0:this._id.hashCode());
        result1 = 31 * result1 + (this.birthdate == null?0:this.birthdate.hashCode());
        result1 = 31 * result1 + (this.created == null?0:this.created.hashCode());
        result1 = 31 * result1 + (this.creator == null?0:this.creator.hashCode());
        result1 = 31 * result1 + (this.creatorService == null?0:this.creatorService.hashCode());
        result1 = 31 * result1 + (this.firstname == null?0:this.firstname.hashCode());
        result1 = 31 * result1 + (this.lastname == null?0:this.lastname.hashCode());
        result1 = 31 * result1 + (this.login == null?0:this.login.hashCode());
        result1 = 31 * result1 + (this.mail == null?0:this.mail.hashCode());
        result1 = 31 * result1 + (this.major?1231:1237);
        result1 = 31 * result1 + (this.picture == null?0:this.picture.hashCode());
        result1 = 31 * result1 + (this.sex == null?0:this.sex.hashCode());
        result1 = 31 * result1 + (this.tags == null?0:this.tags.hashCode());
        result1 = 31 * result1 + (this.tel == null?0:this.tel.hashCode());
        result1 = 31 * result1 + (this.updated == null?0:this.updated.hashCode());
        result1 = 31 * result1 + (this.updator == null?0:this.updator.hashCode());
        result1 = 31 * result1 + (this.updatorService == null?0:this.updatorService.hashCode());
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
            Person other = (Person)obj;
            if(this._id == null) {
                if(other._id != null) {
                    return false;
                }
            } else if(!this._id.equals(other._id)) {
                return false;
            }

            if(this.birthdate == null) {
                if(other.birthdate != null) {
                    return false;
                }
            } else if(!this.birthdate.equals(other.birthdate)) {
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

            if(this.firstname == null) {
                if(other.firstname != null) {
                    return false;
                }
            } else if(!this.firstname.equals(other.firstname)) {
                return false;
            }

            if(this.lastname == null) {
                if(other.lastname != null) {
                    return false;
                }
            } else if(!this.lastname.equals(other.lastname)) {
                return false;
            }

            if(this.login == null) {
                if(other.login != null) {
                    return false;
                }
            } else if(!this.login.equals(other.login)) {
                return false;
            }

            if(this.mail == null) {
                if(other.mail != null) {
                    return false;
                }
            } else if(!this.mail.equals(other.mail)) {
                return false;
            }

            if(this.major != other.major) {
                return false;
            } else {
                if(this.picture == null) {
                    if(other.picture != null) {
                        return false;
                    }
                } else if(!this.picture.equals(other.picture)) {
                    return false;
                }

                if(this.sex == null) {
                    if(other.sex != null) {
                        return false;
                    }
                } else if(!this.sex.equals(other.sex)) {
                    return false;
                }

                if(this.tags == null) {
                    if(other.tags != null) {
                        return false;
                    }
                } else if(!this.tags.equals(other.tags)) {
                    return false;
                }

                if(this.tel == null) {
                    if(other.tel != null) {
                        return false;
                    }
                } else if(!this.tel.equals(other.tel)) {
                    return false;
                }

                if(this.updated == null) {
                    if(other.updated != null) {
                        return false;
                    }
                } else if(!this.updated.equals(other.updated)) {
                    return false;
                }

                if(this.updator == null) {
                    if(other.updator != null) {
                        return false;
                    }
                } else if(!this.updator.equals(other.updator)) {
                    return false;
                }

                if(this.updatorService == null) {
                    if(other.updatorService != null) {
                        return false;
                    }
                } else if(!this.updatorService.equals(other.updatorService)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return !registered;
    }
}
