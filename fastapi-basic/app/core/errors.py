from fastapi import Request, status
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse


class ParameterException(Exception):
    def __init__(self, message: str, code: int = 400):
        self.message = message
        self.code = code


async def parameter_exception_handler(request: Request, exc: ParameterException):
    return JSONResponse(
        status_code=exc.code,
        content={"code": exc.code, "message": exc.message},
    )


async def validation_exception_handler(request: Request, exc: RequestValidationError):
    errors = []
    for error in exc.errors():
        errors.append({
            "field": ".".join(str(loc) for loc in error["loc"]),
            "error_type": error["type"],
            "message": error["msg"],
        })

    return JSONResponse(
        content={
            "code": status.HTTP_422_UNPROCESSABLE_ENTITY,
            "message": "请求数据校验失败",
            "errors": errors,
        },
    )


exception_handlers = [
    (ParameterException, parameter_exception_handler),
    (RequestValidationError, validation_exception_handler),
]