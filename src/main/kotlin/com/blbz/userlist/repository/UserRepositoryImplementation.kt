package com.bridgelabz.fundoo_notes.repository

import com.bridgelabz.fundoo_notes.Entity.UserInformation
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class UserRepositoryImplementation : IUserRepository {
    @Autowired
    private val entityManager: EntityManager? = null

    override fun save(userInformation: UserInformation?): UserInformation? {
        val session: Session = entityManager!!.unwrap(Session::class.java)
        session.saveOrUpdate(userInformation)
        return userInformation
    }

    override fun getUser(email: String?): UserInformation? {
        val session: Session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery(" FROM UserInformation where email=:email")
        q.setParameter("email", email)
        return q.uniqueResult() as UserInformation
    }

    override fun getUserById(id: Long?): UserInformation? {
        val session: Session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery(" FROM UserInformation where id=:id")
        q.setParameter("id", id)
        return q.uniqueResult() as UserInformation
    }

//    override fun upDate(information: PasswordUpdate?, id: Long?): Boolean {
//        val session: Session = entityManager!!.unwrap(Session::class.java)
//        val q = session.createQuery("update UserInformation set password=:p" + " " + " " + "where id=:i")
//        q.setParameter("p", information.getConfirmPassword())
//        q.setParameter("i", id)
//        val status = q.executeUpdate()
//        return if (status > 0) {
//            true
//        } else {
//            false
//        }
//    }

    override fun verify(id: Long?): Boolean {
        val session: Session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery("update UserInformation set is_verified=:p" + " " + " " + "where id=:i")
        q.setParameter("p", true)
        q.setParameter("i", id)
        val status = q.executeUpdate()
        return if (status > 0) {
            true
        } else {
            false
        }
    }

    override fun getUsers(): MutableList<UserInformation?>? {
        val currentsession: Session = entityManager!!.unwrap(Session::class.java)
        return currentsession.createQuery("from UserInformation").resultList as MutableList<UserInformation?>?
    }
}