from pwdlib import PasswordHash

password_hash = PasswordHash.recommended()


def hash_password(plain_password: str) -> str:
    """注册时调用,把明文密码哈希后再存库"""
    return password_hash.hash(plain_password)


def verify_password(plain_password: str, hashed_password: str) -> bool:
    """登录时调用,校验用户输入的密码是否和库里的哈希值匹配"""
    return password_hash.verify(plain_password, hashed_password)

