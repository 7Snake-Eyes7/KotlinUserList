package com.blbz.userlist.repository

import com.blbz.userlist.entity.User
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager


@Repository
class UserRepositoryImplementation : IUserRepository {
    @Autowired
    private val entityManager: EntityManager? = null

    override fun save(userInformation: User): User {
        val session = entityManager!!.unwrap(Session::class.java)
        session.saveOrUpdate(userInformation)
        return userInformation
    }

    override fun getUser(email: String): User {
        val session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery(" FROM UserInformation where email=:email")
        q.setParameter("email", email)
        return q.uniqueResult() as User
    }

    override fun getUserById(id: Long?): User {
        val session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery(" FROM UserInformation where id=:id")
        q.setParameter("id", id)
        return q.uniqueResult() as User
    }


    override fun verify(id: Long?): Boolean {
        val session = entityManager!!.unwrap(Session::class.java)
        val q = session.createQuery("update UserInformation set is_verified=:p" + " " + " " + "where id=:i")
        q.setParameter("p", true)
        q.setParameter("i", id)
        val status = q.executeUpdate()
        return status > 0
    }

    override val users: List<Any>
        get() {
            val currentsession = entityManager!!.unwrap(Session::class.java)
            return currentsession.createQuery("from UserInformation").resultList
        }
}